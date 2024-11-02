Here’s a README for your project:

---

# Serial Abelian Sandpile Simulation

This project implements a serial Abelian Sandpile simulation in Java, organized with a Makefile to facilitate compiling and running the program.

## Project Structure

- **Source Directory**: `src/serialAbelianSandpile`  
- **Binary Directory**: `bin/serialAbelianSandpile`

The Makefile automates the compilation of `.java` source files located in the `src/serialAbelianSandpile` directory, storing the resulting `.class` files in the `bin/serialAbelianSandpile` directory.

## Files

- **AbelianSandpileThread.java**: Defines threads used in the simulation.
- **AutomatonSimulation.java**: The main class, which initiates and runs the sandpile simulation.
- **Grid.java**: Manages the grid data structure and operations for the simulation.

## Usage

### Requirements
- Java Development Kit (JDK)
- A command-line interface (CLI) such as Terminal or Command Prompt.

### Compilation

To compile the project, navigate to the directory containing the Makefile and run:

```bash
make
```

This command will:
1. Create the `bin/serialAbelianSandpile` directory if it doesn't exist.
2. Compile all `.java` files in the `src/serialAbelianSandpile` directory, storing the `.class` files in `bin/serialAbelianSandpile`.

### Running the Program

Once compiled, you can run the simulation with:

```bash
make run
```

This will execute the main class, `serialAbelianSandpile.AutomatonSimulation`, with default arguments specified in the Makefile:

- **Input**: `input/2000_by_2000_All_1.csv`
- **Output**: `output/c.png`

To override the default input and output files, specify `ARGS`:

```bash
make run ARGS="path/to/input.csv path/to/output.png"
```

### Cleaning Up

To remove all compiled files, run:

```bash
make clean
```

## Customization

- **Changing Arguments**: Update the `ARGS` variable in the Makefile to specify different default input/output files if needed.

## License

This project is licensed under the MIT License.

---
