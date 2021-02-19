const WebSocket = require('ws');
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
const ws = new WebSocket('ws://localhost:8888');

ws.on('message', function (data) {
    console.log(`> ${data}`);
});

rl.on('line', (input) => ws.send(input));

//hi입력하면
