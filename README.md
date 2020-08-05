# UDP-client-server-example
CS5352

(1) The client will iterate in a loop. During each iteration, it will get a character string from standard input and send it to the server. The server will also iterate in a loop. During each iteration it will receive a character string and send it back to the client.

(2) In this second modification, the client will still send a character string to the server. However, that character string is the name of a cam- mand. After receiving that cammand name, the server will try to excute that command and send output of the command back to the client. If the server cannot excute the command, it will issue an error message back to the client. The client should just print each line of replies, plus the IP number of replying computer on its standard output.
