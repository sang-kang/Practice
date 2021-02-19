const W3CWebSocket = require('websocket').w3cwebsocket;
const $ = require('jquery');


$(() => {
    const cons = $('#console');                                       //textarea

    function writeToConsole(message) {                                //textArea관련 펑션. 메시지 넘겨받으면
        cons.append(`${message}\n`);                                    //id: console밑에 message넣어준다.
        cons.scrollTop(cons[0].scrollHeight - cons.height());
    }

    let client;
    $('#connect-button').on('click', () => {                        //connectButton누르면
        const address = $('#address-input').val();                    //
        const port = $('#port-input').val();
        const url = `ws://${address}:${port}`;
        console.log(`connecting to ${url}`);
        client = new W3CWebSocket(url);                               //client는 W3CWebSocket에 url넣은 값

        client.onmessage = (evt) => {
            console.log(`> ${evt.data}`);
            writeToConsole(evt.data);
        };

        client.onopen = (evt) => {
            writeToConsole(`Connected to server`);
            $("#chatting-input").attr("disabled", false);
            $("#connect-button").attr("disabled", true);
        };

        client.onerror = (evt) => {
            writeToConsole(`Failed to connect ${JSON.stringify(evt)}`);
        };

        $('#chatting-input').on('keyup', (evt) => {       //사용자가 키보드를 치면
            if(evt.key === 'Enter' || evt.keyCode === 13) {
                const userInput = $('#chatting-input').val();
                console.log(userInput);
                $('#chatting-input').val("");

                $('#username-input').on('keyup', function(event){
                    if(evt.key === 'Enter' || evt.keyCode === 13) {
                        const userName = $('#username-input').val();
                        console.log(userName);
                        client.send(`${userName}]${userInput}`);
                        return;
                    }
                })
                client.send(userInput);
            }
        });
    });




    $('#address-input').on('change', checkInput);

    $('#port-input').on('change', checkInput);

    function checkInput() {
        const address = $('#address-input').val();
        const port = $('#port-input').val();
        if(address && port) {
            $('#connect-button').prop('disabled', false);
        } else {
            $('#connect-button').prop('disabled', true);
        }
    }

});

