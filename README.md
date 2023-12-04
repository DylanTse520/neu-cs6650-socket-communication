# Socket Communication with TCP

## Description

Implement a TCP client and server. The client and server communicate over the network and exchange data.
The server passively listen for a transmission from the client. The client will pass the server a string.
On receiving a string from the client, the server will reverse all character and reverse the capitalization of the string.
The server will then send back the modified string to the client for it to display.

## How to run

After building the two files, first run the server and put "server 32000".
Then run the client and put "client localhost 32000".
Then in client type the message to be transmitted and expect the modified result.