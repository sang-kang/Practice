let WebSocketServer = require('ws').Server;
let wss = new WebSocketServer({port: 8888});

const clientToIdMap = new Map();
let i = 1;
wss.on('git loggiconnection', function (ws) {

    //클라이언트 접속시 임의의 아이디 부여하고 클라이언트에게 해당 정보 send
    console.log('현재 접속한 클라이언트 수' + wss.clients.size);
    clientToIdMap.set(ws, i++);
    console.log('클라이언트가 접속하자 마자 받는 Id' + clientToIdMap.get(ws));
    let firstMessage = {
        type: "automaticallyGeneratedId",
        id: clientToIdMap.get(ws)
    }

    firstMessage.isUserName = true;
    ws.send(JSON.stringify(firstMessage));

    firstMessage.isUserName = false;
    for (let client of wss.clients) {
        client.send(JSON.stringify(firstMessage));
    }

    ws.on('close', function (event) {
        let disconnection = {
            type: "disconnected",
            id: clientToIdMap.get(ws)
        }
        for (let client of wss.clients) {
            client.send(JSON.stringify(disconnection));
        }
        clientToIdMap.delete(ws);
    })

    ws.on('message', function (message) {
            let msg = JSON.parse(message);
            console.log(`${msg.type}도착`);

            /*원래 하려했던 방법
            * let doesExist = fucntion (){
            *   clientToIdMap.forEach(function (value) {
                    if (value == msg.id) {
                        i++;
                        return true;
                    }
                })
            * }
            *
            * doesExist();
            *
            * if(doesExist){
            *
            * }
            * */

            if (msg.type == "setUserId") {
                let i = 0;
                clientToIdMap.forEach(function (value) {
                    if (value == msg.id) {
                        i++;
                        return;
                    }
                })

                if (i > 0) {
                    console.log(`Map검색결과 중복 유저네임 있음. 이 아이디 사용못함`);
                    msg.notChanged = true;
                    ws.send(JSON.stringify(msg));
                    //msg.type = setUserId, msg.id = temporaryUserName, msg.validation=false
                    //msg.notChanged = true
                    return;
                } else {
                    console.log('Map검색결과 중복 유저네임 없음');
                    let originalId = clientToIdMap.get(ws);
                    clientToIdMap.set(ws, msg.id);
                    msg.originalId = originalId;            //변수명을 originId가 아니라 originalId로 하는게 의미상 맞음.

                    //async??await 거는 방법으로 하면 어떨까?
                    for (let client of wss.clients) {
                        client.send(JSON.stringify(msg));
                    }
                    //여기까지는
                    //msg.type = setUserId, msg.id = temporaryUserName,
                    //msg.validation=false, msg.originalId = originalId

                    msg.validation = true;
                    console.log('origin Id뭐 들어있나' + originalId)
                    ws.send(JSON.stringify(msg));
                }
            } else {
                console.log(`msg.type이 message임`)
                for (let client of wss.clients) {
                    client.send(message);
                }
            }
        }
    );
})