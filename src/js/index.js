const W3CWebSocket = require('websocket').w3cwebsocket;
const $ = require('jquery');


$(() => {
  const cons = $('#console');
  function writeToConsole(message) {
    cons.append(`${message}\n`);
    cons.scrollTop(cons[0].scrollHeight - cons.height());
  }

  let client;
  $('#connect-button').on('click', () => {
    const address = $('#address-input').val();
    const port = $('#port-input').val();
    const url = `ws://${address}:${port}`;
    console.log(`connecting to ${url}`);
    client = new W3CWebSocket(url);

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

    $('#chatting-input').on('keyup', (evt) => {
      if(evt.key === 'Enter' || evt.keyCode === 13) {
        const userInput = $('#chatting-input').val();
        console.log(userInput);
        $('#chatting-input').val("");
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

