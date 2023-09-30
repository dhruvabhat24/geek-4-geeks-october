int R = matrix.length;
        int C = matrix[0].length;
        
        // Create two arrays to keep track of rows and columns to be modified
        int rowFlag[] = new int[R];
        int colFlag[] = new int[C];
        
        // Initialize rowFlag and colFlag arrays
        for (int i = 0; i < R; i++) {
            rowFlag[i] = 0;
        }
        for (int i = 0; i < C; i++) {
            colFlag[i] = 0;
        }
        
        // Find the positions of 1s and mark the corresponding rows and columns
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    rowFlag[i] = 1;
                    colFlag[j] = 1;
                }
            }
        }
        
        // Modify the matrix based on rowFlag and colFlag
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rowFlag[i] == 1 || colFlag[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
