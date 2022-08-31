import socket
import threading

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    sock.bind(('', porta))
    sock.listen(5)

    print('Server criado')

    while True:
        conec, addr = sock.accept()
        threading.Thread(target = AnalisaPeso, args = (conec, addr), daemon = True).start()

def AnalisaPeso(conec, addr):
    data = conec.recv(1004).decode()

    args = ["", "", "", ""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    print('valor recebido')
    if str(args[1]) == 'A':
        if int(args[3]) == 0:
            conec.send( str(float(args[2])*0.97).encode() )
        elif int(args[3]) > 0:
            conec.send( str(float(args[2])*0.92).encode() )
   
    elif str(args[1]) == 'B':
        if int(args[3]) == 0:
            conec.send( str(float(args[2])*0.95).encode() )
        elif int(args[3]) > 0:
            conec.send( str(float(args[2])*0.90).encode() )

    if str(args[1]) == 'C':
        if int(args[3]) == 0:
            conec.send( str(float(args[2])*0.92).encode() )
        elif int(args[3]) > 0:
            conec.send( str(float(args[2])*0.85).encode() )

    if str(args[1]) == 'D':
        if int(args[3]) == 0:
            conec.send( str(float(args[2])*0.90).encode() )
        elif int(args[3]) > 0:
            conec.send( str(float(args[2])*0.83).encode() )

if __name__ == '__main__':
    main()