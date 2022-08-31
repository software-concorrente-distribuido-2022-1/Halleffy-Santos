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

        if str(input()) == 'x':
            exit()

def AnalisaPeso(conec, addr):
    data = conec.recv(1004).decode()
    
    valor = ""
    args = []
    for x in data:
        if x == ' ':
            args.append(valor)
            valor = ""
        valor += x
    args.append(valor)

    print(args)

    if int(args[0]) < 5:
        conec.send( 'sem classificacao\n'.encode() )

    elif int(args[0]) >= 5 and int(args[0]) <= 7:
        conec.send( 'infantil A\n'.encode() )

    elif int(args[0]) >= 8 and int(args[0]) <= 10:
        conec.send( 'infantil B\n'.encode() )

    elif int(args[0]) >= 11 and int(args[0]) <= 13:
        conec.send( 'juvenil A\n'.encode() )

    elif int(args[0]) >= 14 and int(args[0]) <= 17:
        conec.send( 'juvenil B\n'.encode() )

    elif int(args[0]) >= 18:
        conec.send( 'adulto\n'.encode() )

if __name__ == '__main__':
    main()