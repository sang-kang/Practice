let WebSocketServer = require('ws').Server;
let wss = new WebSocketServer({port: 8888});

const clientToIdMap = new Map();
let i = 1;
wss.on('connection', function (ws) {

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

            if (msg.type == "setUserId") {
                if (clientToIdMap.get(ws) == msg.id) {
                    console.log(`Map검색결과 중복 유저네임 있음`);
                    ws.send(message);
                    return;
                } else {
                    console.log('Map검색결과 중복 유저네임 없음');
                    let originId = clientToIdMap.get(ws);
                    clientToIdMap.set(ws, msg.id);
                    msg.originId = originId;

                    //for loop한테 async??await걸어야겠다.
                    for (let client of wss.clients) {
                        client.send(JSON.stringify(msg));
                    }

                    msg.validation = true;
                    console.log('origin Id뭐 들어있나' + originId)
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
