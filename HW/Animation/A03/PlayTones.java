import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class PlayTones {
    public static void main(String[] args) {
        ToneGenerator tg = new ToneGenerator();

        try {
            tg.init(); // Initialize the audio system

            // Play 
            tg.play(Note.C5, 300); 
            tg.play(Note.D5, 300); 
            tg.play(Note.E5, 300);
            tg.play(Note.F5, 300); 
            tg.play(Note.G5, 500); 
            tg.play(Note.REST, 200); 
            tg.play(Note.G5, 500); 
            tg.play(Note.A5, 300); 
            tg.play(Note.G5, 300); 
            tg.play(Note.F5, 300); 
            tg.play(Note.E5, 300); 
            tg.play(Note.D5, 500); 

            tg.close(); // Close the audio system
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
