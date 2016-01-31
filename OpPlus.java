package Calc_v_1_2;

public class OpPlus implements Operation {

	@Override
	public double exec(double a, double b) {
		return a + b;
	}

}

class OpMinus implements Operation {

	@Override
	public double exec(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}

}

class OpDiv implements Operation {

	@Override
	public double exec(double a, double b) {
		// TODO Auto-generated method stub
		return a / b;
	}

}

class OpMul implements Operation {
	@Override
	public double exec(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

}