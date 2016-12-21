package ass2.command;

public interface ICommand
{

	boolean canProcess(String dsl);

	boolean process(String dsl);
}
