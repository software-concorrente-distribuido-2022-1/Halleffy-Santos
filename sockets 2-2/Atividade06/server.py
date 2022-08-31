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

    print('valor recebido')
    
    salario = float(args[2])
    if str(args[1]) == 'A':
        if int(args[3]) == 0:
            salario *= 0.97
        elif int(args[3]) > 0:
            salario *= 0.92
   
    elif str(args[1]) == 'B':
        if int(args[3]) == 0:
            salario *= 0.95
        elif int(args[3]) > 0:
            salario *= 0.90

    if str(args[1]) == 'C':
        if int(args[3]) == 0:
            salario *= 0.92
        elif int(args[3]) > 0:
            salario *= 0.85

    if str(args[1]) == 'D':
        if int(args[3]) == 0:
            salario *= 0.90
        elif int(args[3]) > 0:
            salario *= 0.83
    
    conec.send( (str(salario) + '\n').encode() )

if __name__ == '__main__':
    main()