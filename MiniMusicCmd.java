import javax.sound.midi.*;
import static java.lang.System.*;
import maven.*;

class MiniMusicCmd
{
	public static void main(String... arg)
	{
		MiniMusicCmd mmc = new MiniMusicCmd();
		int instrument = MyInput.getInt("Enter Instrument Value (0-127)");
		int note = MyInput.getInt("Enter Note Value (0-127)");
		mmc.play(instrument,note);
	}

	public void play(int instrument,int note)
	{
		try
		{
			Sequencer player = MidiSystem.getSequencer();
			player.open();


			Sequence seq = new Sequence(Sequence.PPQ,4);

			Track track = seq.createTrack();

			ShortMessage chng = new ShortMessage();
			chng.setMessage(192,1,instrument,127);
			MidiEvent changeInst = new MidiEvent(chng,1);
			track.add(changeInst);

			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,note,127);
			MidiEvent nodeOn = new MidiEvent(a,1);
			track.add(nodeOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,note,127);
			MidiEvent nodeOff = new MidiEvent(b,32);
			track.add(nodeOff);

			player.setSequence(seq);
			player.start();
			//Thread.sleep(5000);
			//player.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}


}
