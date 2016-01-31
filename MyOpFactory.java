package Calc_v_1_2;

import java.util.HashMap;
import java.util.Map;


public class MyOpFactory implements OperationFactory {
	Operation loadClassOper;
	String op;

	@Override
	public Operation getOpInstance(String op) {
		// TODO Auto-generated method stub
		this.op = op;
		Map<Operation, Operation> map = new HashMap<>();
        	
		
		switch (op) {
		case "+": {
//			loadClassOper = new OpPlus();
		    map.put(loadClassOper, new OpPlus());
			break;
		}
		case "-": {
//			loadClassOper = new OpMinus();
			map.put(loadClassOper, new OpMinus());			
			break;
		}

		case "*": {
//			loadClassOper = new OpMul();
			map.put(loadClassOper, new OpMul());
			break;
		}

		case "/": {
//			loadClassOper = new OpDiv();
			map.put(loadClassOper, new OpDiv());
			break;
		}
		default:
			map.put(loadClassOper,null);
			break;
		}
		return map.get(loadClassOper);
	}
	/*
	 * public static void main(String[] args) { MyOpFactory m = new
	 * MyOpFactory(); System.out.println(m.getOpInstance("+")); }
	 */
}
