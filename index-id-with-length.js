let $ = require('jquery');

const W3CWebSocket = require('websocket').w3cwebsocket;
const client = new W3CWebSocket('ws://localhost:8888');

// const client = new W3CWebSocket(serverInfo);


// client.onmessage = (data) => {
//     console.log(data);
// };

//서버에서 받아와서 textArea에 뿌림
// let chatArea = document.querySelector(".chat");
//     client.onmessage = (data) => {
//         console.log(data);
//         //이렇게하면 채팅내역 하나만 계속 나옴.
//         //chatArea.value = data.data;
//
//         let dataArray = new Array();
//         dataArray.push(data.data);                  //이렇게하면 선입후출 이라서 밑에서 다시 length에 넣고 0부터 뺀것.
//         for(let i=0; i<dataArray.length; i++){
//             $(".chat").append(`${dataArray[i]} \n`);    //형 코드 참고하였다.
//         }
//     };



//메시지 입력하는 공간
// $(".messageButton").click(function (){
//     let message = document.querySelector(".message").value;
//
//     //클라이언트의 메시지 서버로 보내기
//     //이때 address, port에서 받은 번호 필요
// //    var serverInfo = sendServerInfo();
//     client.send(message);
// })

//사용자로부터 이름 입력받아서 1, 2번이 아니라 이제 그 이름으로 나오게 하기.
// $(".user-name-button").on('click', function (){
//     const userName = $(".user-name").val();
//     client.send(userName);          //이렇게 보내면 message로 간다.
// })


$(".messageButton").click(function (){
    let message = document.querySelector(".message").value;
    let userName = null;
    $(".user-name-button").on('click', function (){
        let userName = $(".user-name").val();

        let msg = {
            type: "message",
            text: message,
            id: userName
        }
        // console.log('client쪽에서의 msg:' + JSON.stringify(msg));
        // client.send(JSON.stringify(msg));
        client.send(`${msg.id}]${msg.text}`);

        message = "";
        userName = "";
    });
})











//메시지 입력전에 먼저 실행해야 함.
// $(".sendServerInfo").click(function (){
//     let address = document.querySelector(".address").value;
//     let port = document.querySelector(".port").value;
//     let chatServer = `ws://${address}:${port}`;
//     return chatServer;
// })


//사용자 입력란 만들고
//해당문구가 사용자의 id가 되도록. 그리고 그 id가 메시지 보낼때 뜨도록