import java.util.Scanner;
/**
 * Write a description of class LagerDialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LagerDialog
{
    
    private Lager lager1;
    private Scanner input = new Scanner(System.in);
    
    private static final int ANLEGEN = 1;
    private static final int AUSGABE = 2;
    private static final int EINNAHME = 3;
    private static final int LAGERLAUFRUFEN = 4;
    private static final int ENDE = 0;
    private static final int INIT = -1;
    
    public LagerDialog(){}
    
    public void start(){
        lager1 = null;
        int funktion = INIT;
        while (funktion != ENDE){
            try{
                funktion = leser();
                ausfuehrer(funktion);
            } catch(AssertionError e) {
                System.out.println(e);
            } catch (Exception e){
                System.out.println("Eine ausnahme wurde gefunden" + e);
                e.printStackTrace(System.out);
            }
        }
    }
    
    private int leser(){
        System.out.print(ANLEGEN + ": anlegen; " +
            AUSGABE         + ": ausgabe; "                +
            EINNAHME        + ": einnahme; "               +
            LAGERLAUFRUFEN + ": Lager aufrufen; "       +
            ENDE            +": beenden--> ");
        return input.nextInt();
    }
    
    private void ausfuehrer(int funktion){
        switch(funktion){
            case 1: lager1 = anlegenDialog();
            break;
            case 2: lager1 = ausgabeDialog();
            break;
            case 3: lager1 = einnahmeDialog();
            break;
            case 4: lager1 = aufrufenDialog();
            break;
        
        }
    }
    
    private Lager anlegenDialog(){
    }
    
    private Lager ausgabeDialog(){
    }
    
    private Lager einnahmeDialog(){
    }
    
    private Lager aufrufenDialog(){
    }
}
