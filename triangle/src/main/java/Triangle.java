class Triangle {
	private double side1, side2, side3;

	Triangle(double i, double i1, double i2) throws TriangleException {
		validateTriangle(i, i1, i2);
		side1 = i;
		side2 = i1;
		side3 = i2;
	}

	private void validateTriangle(double i, double i1, double i2) throws TriangleException {
		if (i <= 0 || i1 <= 0 || i2 <= 0 || isViolating(i, i1, i2)) {
			throw new TriangleException();
		}
	}

	private boolean isViolating(double i, double i1, double i2) {
		double max = Math.max(i, Math.max(i1, i2));
		return max >= (i + i1 + i2 - max);
	}

	TriangleKind getKind() {
		if (side1 == side2 && side3 == side1) {
			return TriangleKind.EQUILATERAL;
		} else if (side1 == side2 || side1 == side3 || side2 == side3) {
			return TriangleKind.ISOSCELES;
		} else {
			return TriangleKind.SCALENE;
		}
	}
}
