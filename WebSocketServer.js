let WebSocketServer = require('ws').Server;
let wss = new WebSocketServer({port:8888});

//const idMap = new Map();
const wsArray = [];
wss.on('connection', function(ws) {     //응답을 받는다.
    // function(ws, req)로 해볼랬는데 안됐음.
    //    console.log('connected:' + req.connection.remoteAddress);


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

    ws.on('message', function(message) {
        // let msg = JSON.parse(event.data);
        // console.log('msg.text:' + msg.text);
        // console.log('msg.id:' + msg.id);
        console.log('서버쪽에서의 msg:'+ message)

        for(let client of wss.clients){
            //client.send(`${msg.id}]${msg.text}`);
            client.send(message);
        }
    });


});


/*과제
* 클라이언트가 하나씩 들어올때마다 서버는 1++씩 번호 부여
* 클라이언트에서 메시지가 오면 서버가 다시 클라이언트에게 뿌릴때 번호]메시지 이렇게 가도록
* */