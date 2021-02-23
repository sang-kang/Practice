let $ = require('jquery');

const W3CWebSocket = require('websocket').w3cwebsocket;
let client = null;

$(document).ready(function () {
    let userName = undefined;
    $(".sendServerInfo").click(function connectUrl() {
        let address = document.querySelector(".address").value;
        let port = document.querySelector(".port").value;
        let chatServer = `ws://${address}:${port}`;
        client = new W3CWebSocket(chatServer);

        console.log("connected");

        client.onmessage = (data) => {
            let messageFromServer = JSON.parse(data.data);
            console.log('서버로부터 메시지 받음' + messageFromServer.type)
            console.log(messageFromServer);

            if (messageFromServer.type == "automaticallyGeneratedId") {
                if (messageFromServer.isUserName) {
                    userName = messageFromServer.id;
                }
                alert(`${messageFromServer.id}가 접속했습니다.`);
                return;
            }

            if (messageFromServer.type == "disconnected") {
                alert(`${messageFromServer.id}가 나갔습니다.`);
                return;
            }

            if (messageFromServer.type == "setUserId") {
                alert(`${messageFromServer.originId}가 ${messageFromServer.id}로 바꼈습니다.`)

                if (messageFromServer.validation) {
                    userName = messageFromServer.id;
                    console.log('validation=true: ' + userName);
                }
            } else {
                let chatArea = document.querySelector(".chat");
                $(".chat").append(`${messageFromServer.id}]${messageFromServer.text} \n`);
            }
        }
        console.log("connected2");
    });

    $(".user-name-button").on('click', function () {
        let temporaryUserName = $(".user-name").val();
        console.log(`템포러리 유저네임: ${temporaryUserName}`);

        let userIdSetting = {
            type: "setUserId",
            id: temporaryUserName,
            validation: false
        }
        client.send(JSON.stringify(userIdSetting))
    });

    $(".messageButton").click(function () {
        let message = document.querySelector(".message").value;
        let msg = {
            type: "message",
            text: message,
            id: userName
        }
        client.send(JSON.stringify(msg));
    });

    $(".disconnect-button").click(function () {
        console.log('서버와의 연결 끊김1');
        client.close();     //이 부분 잘 못했음.
        console.log('서버와의 연결 끊김2');
    })
})
