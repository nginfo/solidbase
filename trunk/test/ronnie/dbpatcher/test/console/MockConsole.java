package ronnie.dbpatcher.test.console;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.io.output.TeeOutputStream;

import ronnie.dbpatcher.Console;

import com.logicacmg.idt.commons.util.Assert;

public class MockConsole extends Console
{
	protected Queue< String > answerQueue = new LinkedList< String >();
	protected ByteArrayOutputStream outputBuffer;
	protected ByteArrayOutputStream errorBuffer;

	public MockConsole()
	{
		this.prefixWithDate = false;
		this.outputBuffer = new ByteArrayOutputStream();
		this.errorBuffer = new ByteArrayOutputStream();
		this.out = new PrintStream( new TeeOutputStream( this.outputBuffer, this.out ) );
		this.err = new PrintStream( new TeeOutputStream( this.errorBuffer, this.err ) );
	}

	public void addAnswer( String answer )
	{
		this.answerQueue.offer( answer );
	}

	public String getOutput()
	{
		return this.outputBuffer.toString();
	}

	public String getErrorOutput()
	{
		return this.errorBuffer.toString();
	}

	@Override
	public synchronized String input() throws IOException
	{
		String input = this.answerQueue.poll();
		Assert.notNull( input, "No more input" );

		this.col = 0;
		return input;
	}
}