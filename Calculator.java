package Calc_v_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Calculator {
	private MyOpFactory mof;

	private final String pathToProp = "/home/jerald/workspace/myProj/src/Calc_v_1_2/log.properties";
	private final Logger log = Logger.getLogger(Calculator.class);

	public Calculator(MyOpFactory mof) {
		this.mof = mof;
	}

	private String readData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	public void exec() throws IOException, OperationNotFoundException {
		PropertyConfigurator.configure(pathToProp);
		BasicConfigurator.configure();

		System.out.println("Input 'exit' and press 'Enter' for quit");

		do {
			String a = readData();
			String[] spl = a.split("\\+|\\-|\\*|\\/");
			String[] chr = a.split("\\d");

			if ((a.equals("exit"))) {
				log.info("is over");
				break;
			}

			String c = null;
			for (int i = 0; i < chr.length; i++) {
				if ((!chr[i].equals("")) && (!chr[i].equals("."))) {
					c = chr[i];
				}
			}

			if ((!c.equals("+")) && (!c.equals("-")) && (!c.equals("*")) && (!c.equals("/"))) {
				log.error(new OperationNotFoundException("Operation not found"));
				throw new OperationNotFoundException("Operation not found");
			}
			double x = Double.parseDouble(spl[0]);
			double y = Double.parseDouble(spl[1]);

			Operation res = mof.getOpInstance(c);
			log.info(x + " " + c + " " + y + " = " + res.exec(x, y));

		} while (true);
	}

	public static void main(String[] args) throws IOException, OperationNotFoundException {
		MyOpFactory mf = new MyOpFactory();
		Calculator calc = new Calculator(mf);
		calc.exec();
	}
}