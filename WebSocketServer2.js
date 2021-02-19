let WebSocketServer = require('ws').Server;
let wss = new WebSocketServer({port:8888});

wss.on('connection', function(ws) {
    ws.on('message', function(message) {
        console.log(`${message} 받음`);
        //message에 어느 클라이언트에서 왔는지 정보 있을거 같은데..
        //message가 누구한테서 왔는지 알아야 한다.

        let i = 0;
        for(let client of wss.clients){
            client.number = i++;
            //console.log(`wss클라이언트의 타입 : ${typeof wss.clients}`);
            client.send(`${message.}] ${message}`);
        }


        //메시지는 1번 클라이언트에게 받음
        //client.send하면 1번 클라이언트에게는 1]message
        //2번 클라이언트에게는 2]message이렇게 감.


        // for(let [key, value] of wss.clients.entries()){
        //     console.log(typeof wss.clients)
        //     client.send(`${key}] ${message}`);
        // }

        // for(let i = 0; i<wss.clients.size; i++){
        //     for(let client of wss.clients){
        //         client.number = i++;
        //         //console.log(`wss클라이언트의 타입 : ${typeof wss.clients}`);
        //         client.send(`${message.}] ${message}`);
        //     }
        // }
    });
});

/*과제
* 클라이언트가 하나씩 들어올때마다 서버는 1++씩 번호 부여
* 클라이언트에서 메시지가 오면 서버가 다시 클라이언트에게 뿌릴때 번호]메시지 이렇게 가도록
* */