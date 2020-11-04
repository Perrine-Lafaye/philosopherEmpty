package diningphilosophers;

public class ChopStick {
    // Le nombre total de baguettes
    private static int stickCount = 0;
    // Le numéro de chaque baguette
    private final int myNumber;
    // Est-ce que ma baguette est libre ?
    private boolean iAmFree = true;

    public ChopStick() {
        // Chaque baguette est numérotée 
        myNumber = ++stickCount;
    }

synchronized void take() throws InterruptedException{
     //attendre que la baguette soit libre
     while (!iAmFree) {
            wait(); // peut lever InterrupedException
    }               //Deplier
    assert (iAmFree);
    this.iAmFree = false;
 //on est sur que la baguette soit libre
    // ajouter à la fin de la liste
    System.out.printf("La baguette" + myNumber + "est prise");
    notifyAll(); //Notifier que la baguette n'est plus libre
}

synchronized void release() throws InterruptedException{
    //attendre que la baguette soit prise
    while(iAmFree){
          wait();
    }
    assert (!iAmFree);
    this.iAmFree = true;
    System.out.printf("La baguette" + myNumber + "est libre");
    notifyAll();
}

   
    
    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
