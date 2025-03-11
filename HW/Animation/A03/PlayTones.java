import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class PlayTones {
    public static void main(String[] args) {
        ToneGenerator tg = new ToneGenerator();

        try {
            tg.init(); // Initialize the audio system

            // Play a simple melody
            tg.play(Note.C5, 300); // C5 for 300ms
            tg.play(Note.D5, 300); // D5 for 300ms
            tg.play(Note.E5, 300); // E5 for 300ms
            tg.play(Note.F5, 300); // F5 for 300ms
            tg.play(Note.G5, 500); // G5 for 500ms
            tg.play(Note.REST, 200); // Rest for 200ms
            tg.play(Note.G5, 500); // G5 for 500ms
            tg.play(Note.A5, 300); // A5 for 300ms
            tg.play(Note.G5, 300); // G5 for 300ms
            tg.play(Note.F5, 300); // F5 for 300ms
            tg.play(Note.E5, 300); // E5 for 300ms
            tg.play(Note.D5, 500); // D5 for 500ms

            tg.close(); // Close the audio system
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
