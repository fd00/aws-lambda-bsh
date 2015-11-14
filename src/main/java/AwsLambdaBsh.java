import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import bsh.EvalError;
import bsh.Interpreter;

public class AwsLambdaBsh implements RequestHandler<String, String> {
	public String handleRequest(String input, Context context) {
		Interpreter interpreter = new Interpreter();
		try {
			interpreter.eval(input);
			return interpreter.get("result").toString();
		} catch (EvalError e) {
			return e.toString();
		}
	}
}
