void main(String[] args) {
    if (args.length < 2)
    {
        System.out.println("sintaxa ceruta: java Matrix2D <n> <forma>");
        return;
    }


    int n = Integer.parseInt(args[0]);
    String forma = args[1];


    long startTime = System.nanoTime();

    int[][] matrix = new int[n][n];

    if (forma.equalsIgnoreCase("rectangle"))
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > n / 4 && i < 3 * n / 4 && j > n / 4 && j < 3 * n / 4) matrix[i][j] = 0; // formula pentru incadrare
                else matrix[i][j] = 255;
            }
        }

    } else
    {
        int center = n / 2;
        int radius = n / 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double dist = Math.sqrt(Math.pow(i - center, 2) + Math.pow(j - center, 2)); //formula matematica
                if (dist <= radius) matrix[i][j] = 255;
                else matrix[i][j] = 0;
            }
        }
    }

    long endTime = System.nanoTime();


    if (n <= 30)
    {
        System.out.println(matrixToString(matrix));
    } else
    {
        System.out.println("Timp executie: " + (endTime - startTime) + " nanosecunde");
    }
}


String matrixToString(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int[] row : matrix) {
        for (int pixel : row) {
            sb.append(pixel == 0 ? "█" : "░");
        }
        sb.append("\n");
    }
    return sb.toString();
}
