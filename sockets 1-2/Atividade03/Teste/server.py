from concurrent.futures import thread
import socket
import threading

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    sock.bind(('', porta))
    sock.listen(5)

    print('Server criado.')

    while True:
        con, addr = sock.accept()
        print('Connection accepted.')
        t = threading.Thread(target=AnaliseNotas, args = (con, addr), daemon = True)
        t.start()

def AnaliseNotas(con, addr):
    data = con.recv(1024).decode()

    args = ["", "", ""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    resultado = False
    if (float(args[0]) + float(args[1]))/2 >= 7:
        resultado = True
    elif (float(args[0]) + float(args[1]))/2 >= 3 and (float(args[1]) + float(args[2]))/2 >= 5: 
        resultado = True
    
    print('Aprovado') if resultado else print('Reprovado')
    con.send('Aprovado'.encode()) if resultado else con.send('Reprovado'.encode())

if __name__ == '__main__':
    main()