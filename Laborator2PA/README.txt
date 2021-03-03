Explicatii

Pentru a descrie solutia problemei am creat o clasa Solution care va avea un cost total, o problema si un LinkedList de instante dintr-o clasa anonima Shipment.
Clasa Shipment va stoca urmatoarele informatii : sursa, destinatia si costul pentru a face transferul.
Pe langa settere, gettere si constructori, in clasa Solution am adaugat urmatoarea metoda: solveProblem (care va juca rolul de "main" pentru aflarea solutiei) 
urmata de metodele necesare algoritmului realizat.

In acest algoritm vom verifica prima data daca exista cu adevarat o solutie posibila pentru aceasta problema, asta insemnand ca suma cererilor din destinatii 
sa fie mai mica sau egala cu suma proviziilor din surse.
Daca nu exista, atunci afisam un mesaj de eroare, dar daca exista atunci putem continua algoritmul.
Cat timp ramane macar o destinatie careia nu i-a fost satisfacuta cererea de catre surse vom cauta transferul de cost minim ( posibil doar din sursele care mai
 au provizii ).
Daca avem o sursa care inca mai are provizii, atunci cautam destinatia cu costul cel mai mic de transfer de la sursa curenta care mai are nevoie de provizii.
 Odata gasita aceasta destinatie vom calcula costul final pentru transfer si vom face scaderile corespunzatoare proviziilor si cererilor:
 
caz 1. cererea >= provizii 
Proviziile se vor epuiza si din cerere se va scadea cat pot acoperi proviziile din sursa curenta iar destinatia va ramane sa fie aprovizionata mai tarziu de alta/alte sursa/surse 

caz 2. cererea < proviziile
Cererea este acoperita complet de catre proviziile din sursa curenta si doar se va scadea nr de provizii transferate catre destinatie.

Costul calculat la fiecare transfer sa va adauga la costul final.
Pentru fiecare transfer facut se va crea o noua instanta a clasei Shipment care va primi numele sursei, numele destinatiei si costul aferent transferului. 
