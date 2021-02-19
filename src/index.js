let $ = require('jquery');

const W3CWebSocket = require('websocket').w3cwebsocket;
let client = null;


//서버연결
$(".sendServerInfo").click(function connectUrl(){
    let address = document.querySelector(".address").value;
    let port = document.querySelector(".port").value;
    let chatServer = `ws://${address}:${port}`;
    client = new W3CWebSocket(chatServer);
// })   나중에 살릴것


//서버에서 받은 메시지 chatArea에 메시지 뿌림.
let chatArea = document.querySelector(".chat");
    client.onmessage = (data) => {
        console.log(data);
        $(".chat").append(`${data.data} \n`);
     };
});     //나중에 지울것

let userName;
let msg = {
    type: "message",
    text: null,
    id: null
}
//유저네임 입력
$(".user-name-button").on('click', function (){
    console.log('username: ' + $(".user-name").val());
    userName = $(".user-name").val();
});

//메시지 입력하는 공간
$(".messageButton").click(function (){
    let message = document.querySelector(".message").value;

    msg = {
        type: "message",
        text: message,
        id: userName
    }
    client.send(`${msg.id}]${msg.text}`);

    message = "";
});
