let WebSocketServer = require('ws').Server;
let wss = new WebSocketServer({port: 8888});

//const idMap = new Map();
//let wsArray = [];
let clientArray = new Array();
wss.on('connection', function (ws, request, client) {     //응답을 받는다.
    // function(ws, req)로 해볼랬는데 안됐음.
    //    console.log('connected:' + request.connection.remoteAddress);

    //ws연결되면 wsArray에 하나씩 넣자
    // wsArray.push(ws);
    // ws.id = wsArray.length;
    // console.log(`나의 아이디는 ${ws.id}`);
    //
    // ws.on('message', function(message) {
    //     console.log(`${message} 받음`);
    //
    //     for(let client of wss.clients){
    //         client.send(`${ws.id}]${message}`);
    //     }
    // });

    ws.on('message', function (message) {
        // //클라이언트에서 보내는 message JSON객체화
        // let msg = JSON.parse(message);
        // //클라이어느에서 넘어온 msg.type에 따른 처리
        // if(msg.type == "setUserId"){
        //
        // } else {
        //
        // }
        //
        // let clientID = msg.id;
        // let clientMessage = msg.text;

        //클라이언트에서 보내는 message JSON객체화를 여기에 놓는게 맞겠다.
        let msg = JSON.parse(message);

        //일단은 있는지 없는지 체크부터 하는게 먼저.
        let clientInfo = request.headers['sec-websocket-key'];
        let clientID;
        let clientMessage;
        console.log(`clientArray길이: ${clientArray.length}`);

        if (msg.type == "setUserId") {
            //현재있는 배열에서 있나없나부터 살펴봐야 되는데. 먄약 clientArray가 없으면 만들고 있으면 loop돌면되지
            console.log('userIdSetting도착');
            if(clientArray.length == 0){
                console.log('clientArray.length = 0')
                clientID = msg.id;
                clientMessage = msg.text;
                let clientToClientIdMap = new Map();
                clientToClientIdMap.set(clientInfo, clientID);
                console.log(`맵에 처음 값 넣고;${clientToClientIdMap.get(clientInfo)}`)
                //어레이에다가 맵 넣고
                clientArray.push(clientToClientIdMap);
                console.log(`Array length 0인 상황에서 array추가하면: ${clientArray.length}`);
                console.log(`array 0번째 있는 값: ${clientArray[0].get(clientInfo)}`);
            } else {
                console.log(`clientArray.length : ${clientArray.length}`)
                for (let i = 0; i < clientArray.length; i++){//array돌면서
                    console.log(`각각의 맵 값은 무엇이냐: ${clientArray[i].get(clientInfo)}`);

                    if(msg.id == clientArray[i].get(clientInfo)){  //array에 같은아이디 있다면
                        console.log('array에 같은 userName존재')
                        clientInfo.send('유효하지 않은 유저네임');
                        return;
                    } else {                                    //어레이에 이놈 없으면
                        console.log(`msg.id는 무엇이냐: ${msg.id}`)
                        console.log('array에 같은 userName존재하지 않음')
                        clientID = msg.id;
                        clientMessage = msg.text;
                        //맵에다가 매핑하고
                        let clientToClientIdMap = new Map();
                        clientToClientIdMap.set(clientInfo, clientID);
                        //어레이에다가 맵 넣고
                        clientArray.push(clientToClientIdMap);
                        //결과 suceess로 보냄.
                        //여기다가 client.send('success')
                        clientInfo.send('success');
                    }
                }
            }
        } else {
            //msg.type가 setUserId아니면 msg.type이 message란 말이고 그러면 userIdSetting.id가 userName으로 넘어오기 때문에 따로 처리할 필요 없음
            console.log('msg의 타입이 userIdSetting아님')
            clientID = msg.id;
            clientMessage = msg.text;
        }

        console.log(`서버가 클라이언트에게: ${clientID}]${clientMessage}`);

        for (let client of wss.clients) {     //여기에서 client는 클라이언트의 소캣 하나하나

            //client.send(`${msg.id}]${msg.text}`);
            //client.send(`${clientID}]${clientMessage}`);
            if (clientID === undefined) {
                return;
            }
            client.send(JSON.stringify(msg));
            //client.send(message);       //받은 message자체가 JSON.stringfy해서 받은거니까 굳이 다시 바꿀 필요 없음
        }
    });
})


/*과제
* 클라이언트가 하나씩 들어올때마다 서버는 1++씩 번호 부여
* 클라이언트에서 메시지가 오면 서버가 다시 클라이언트에게 뿌릴때 번호]메시지 이렇게 가도록
* */