Set – A
Program 1
Write and execute a Python program using Qiskit to implement the Deutsch–Jozsa
Algorithm for a balanced function.
Your program should:
 Create the required quantum circuit
 Apply Hadamard gates appropriately
 Implement a balanced oracle
 Measure the qubits and display the result
Expected Outcome:
The output should identify whether the function is balanced or constant.

///////////////////////////////////////////////////
from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# Number of input qubits
n = 3

# Create quantum circuit
qc = QuantumCircuit(n + 1, n)

# Initialize output qubit to |1>
qc.x(n)

# Apply Hadamard gates to all qubits
for qubit in range(n + 1):
    qc.h(qubit)

# -------------------------
# Balanced Oracle
# f(x) = x1 XOR x2 XOR x3
# -------------------------
for qubit in range(n):
    qc.cx(qubit, n)

# Apply Hadamard gates again to input qubits
for qubit in range(n):
    qc.h(qubit)

# Measure input qubits
for qubit in range(n):
    qc.measure(qubit, qubit)

# Execute the circuit
simulator = AerSimulator()
compiled_circuit = transpile(qc, simulator)
job = simulator.run(compiled_circuit, shots=1024)

# Get results
result = job.result()
counts = result.get_counts()

print("Measurement Result:", counts)

# Determine function type
if '000' in counts:
    print("The function is CONSTANT")
else:
    print("The function is BALANCED")

# Draw circuit
print(qc.draw())


/////////////////////////////////////////////

Program 2
Write and execute a Python program to implement Quantum Teleportation.
Your program should:
 Create an unknown qubit state
 Generate Bell pair entanglement
 Perform Bell measurement
 Apply conditional operations at the receiver side
 Display the final state/output
Expected Outcome:
The transmitted qubit state should be reconstructed successfully at the receiver end.

///////////////////////////////////////////

from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# Create quantum circuit with 3 qubits and 3 classical bits
qc = QuantumCircuit(3, 3)

# ------------------------------------------------
# Step 1: Create unknown qubit state on qubit 0
# ------------------------------------------------
qc.h(0)

# ------------------------------------------------
# Step 2: Generate Bell Pair between qubit 1 and 2
# ------------------------------------------------
qc.h(1)
qc.cx(1, 2)

# ------------------------------------------------
# Step 3: Bell Measurement
# ------------------------------------------------
qc.cx(0, 1)
qc.h(0)

qc.measure(0, 0)
qc.measure(1, 1)

# ------------------------------------------------
# Step 4: Conditional Operations at Receiver Side
# ------------------------------------------------
qc.x(2).c_if(qc.clbits[1], 1)
qc.z(2).c_if(qc.clbits[0], 1)

# Measure receiver qubit
qc.measure(2, 2)

# Execute the circuit
simulator = AerSimulator()
compiled_circuit = transpile(qc, simulator)

job = simulator.run(compiled_circuit, shots=1024)
result = job.result()

# Display results
counts = result.get_counts()

print("Quantum Teleportation Result:")
print(counts)

# Draw the circuit
print(qc.draw())

////////////////////////////////

Set – B
Program 1
Write and execute a Python program to implement Super Dense Coding using Qiskit.
Your program should:
 Create Bell state entanglement
 Encode two classical bits using quantum gates
 Decode the transmitted message
 Measure and display the received classical bits
Expected Outcome:
The receiver should correctly recover the two-bit classical message.


///////////////////////////////////

from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# Create quantum circuit with 2 qubits and 2 classical bits
qc = QuantumCircuit(2, 2)

# ------------------------------------------------
# Step 1: Create Bell State Entanglement
# ------------------------------------------------
qc.h(0)
qc.cx(0, 1)

# ------------------------------------------------
# Step 2: Encode Two Classical Bits
# Message to send = "10"
# Apply Z gate for first bit = 1
# Apply X gate for second bit = 0 (not applied)
# ------------------------------------------------
qc.z(0)

# ------------------------------------------------
# Step 3: Decode the Message
# ------------------------------------------------
qc.cx(0, 1)
qc.h(0)

# ------------------------------------------------
# Step 4: Measure the Qubits
# ------------------------------------------------
qc.measure([0, 1], [0, 1])

# Execute the circuit
simulator = AerSimulator()
compiled_circuit = transpile(qc, simulator)

job = simulator.run(compiled_circuit, shots=1024)
result = job.result()

# Display result
counts = result.get_counts()

print("Super Dense Coding Result:")
print(counts)

# Display received message
received_message = list(counts.keys())[0]
print("Received Classical Bits:", received_message)

# Draw the circuit
print(qc.draw())

///////////////////////////////////


Program 2
Write and execute a Python program to generate and verify Bell States.
Your program should:
 Construct all four Bell states using quantum gates
 Perform measurements
 Display the corresponding outputs/state vectors
Expected Outcome:
The program should correctly generate entangled Bell states.

/////////////////////////////////


from qiskit import QuantumCircuit, transpile
from qiskit.quantum_info import Statevector
from qiskit_aer import AerSimulator

# Function to create Bell states
def create_bell_state(state_name):
    qc = QuantumCircuit(2, 2)

    # Create Bell states
    if state_name == "Phi+":
        qc.h(0)
        qc.cx(0, 1)

    elif state_name == "Phi-":
        qc.h(0)
        qc.cx(0, 1)
        qc.z(0)

    elif state_name == "Psi+":
        qc.h(0)
        qc.cx(0, 1)
        qc.x(1)

    elif state_name == "Psi-":
        qc.h(0)
        qc.cx(0, 1)
        qc.x(1)
        qc.z(1)

    # Get statevector before measurement
    statevector = Statevector.from_instruction(qc)

    # Measurement
    qc.measure([0, 1], [0, 1])

    # Execute circuit
    simulator = AerSimulator()
    compiled_circuit = transpile(qc, simulator)

    job = simulator.run(compiled_circuit, shots=1024)
    result = job.result()

    counts = result.get_counts()

    # Display results
    print("\nBell State:", state_name)
    print("Statevector:")
    print(statevector)
    print("Measurement Output:")
    print(counts)

    # Draw circuit
    print(qc.draw())


# Generate all four Bell states
create_bell_state("Phi+")
create_bell_state("Phi-")
create_bell_state("Psi+")
create_bell_state("Psi-")


/////////////////////////////////


Set – C
Program 1
Write and execute a Python program to generate an EPR State and GHZ State using Qiskit.
Your program should:
 Create entanglement between qubits
 Implement EPR state generation
 Extend the circuit to create a GHZ state
 Measure and display the outputs
Expected Outcome:
The output should demonstrate multi-qubit entanglement.


/////////////////////////////////////////////////


from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# ------------------------------------------------
# EPR STATE GENERATION
# ------------------------------------------------
epr = QuantumCircuit(2, 2)

# Create EPR entanglement
epr.h(0)
epr.cx(0, 1)

# Measure qubits
epr.measure([0, 1], [0, 1])

# Execute EPR circuit
simulator = AerSimulator()
compiled_epr = transpile(epr, simulator)

job1 = simulator.run(compiled_epr, shots=1024)
result1 = job1.result()

print("EPR State Output:")
print(result1.get_counts())

# Draw EPR circuit
print(epr.draw())

# ------------------------------------------------
# GHZ STATE GENERATION
# ------------------------------------------------
ghz = QuantumCircuit(3, 3)

# Create GHZ entanglement
ghz.h(0)
ghz.cx(0, 1)
ghz.cx(1, 2)

# Measure qubits
ghz.measure([0, 1, 2], [0, 1, 2])

# Execute GHZ circuit
compiled_ghz = transpile(ghz, simulator)

job2 = simulator.run(compiled_ghz, shots=1024)
result2 = job2.result()

print("\nGHZ State Output:")
print(result2.get_counts())

# Draw GHZ circuit
print(ghz.draw())



///////////////////////////////////

Program 2
Write and execute a Python program to implement a Combinational Logic Circuit using
Quantum Gates.
Your program should:
 Design a logic circuit using basic quantum gates (X, CNOT, Toffoli, etc.)
 Simulate logical operations such as AND/OR/XOR
 Measure and display the results
Expected Outcome:
The program should correctly simulate the desired logical operation using quantum gates.


///////////////////////////////

from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# ------------------------------------------------
# Quantum Combinational Logic Circuit
# AND, OR, XOR using Quantum Gates
# ------------------------------------------------

# Create circuit with 4 qubits and 4 classical bits
# q0 = input A
# q1 = input B
# q2 = XOR output
# q3 = AND output
qc = QuantumCircuit(4, 4)

# ------------------------------------------------
# Input values
# A = 1, B = 1
# ------------------------------------------------
qc.x(0)
qc.x(1)

# ------------------------------------------------
# XOR Operation using CNOT Gates
# XOR result stored in q2
# ------------------------------------------------
qc.cx(0, 2)
qc.cx(1, 2)

# ------------------------------------------------
# AND Operation using Toffoli Gate
# AND result stored in q3
# ------------------------------------------------
qc.ccx(0, 1, 3)

# ------------------------------------------------
# OR Operation
# OR = A XOR B XOR (A AND B)
# Stored in q2
# ------------------------------------------------
qc.cx(3, 2)

# ------------------------------------------------
# Measure all qubits
# ------------------------------------------------
qc.measure([0, 1, 2, 3], [0, 1, 2, 3])

# Execute circuit
simulator = AerSimulator()
compiled_circuit = transpile(qc, simulator)

job = simulator.run(compiled_circuit, shots=1024)
result = job.result()

# Display results
counts = result.get_counts()

print("Quantum Logic Circuit Output:")
print(counts)

# Draw circuit
print(qc.draw())


/////////////////////////


Set – D
Program 1
Write and execute a Python program to implement Shor’s Algorithm for factorizing a small
integer number using Qiskit simulation.
Expected Outcome:
The program should identify the factors of the given number.

//////////////////////////////////

from qiskit.algorithms import Shor
from qiskit_aer import AerSimulator
from qiskit.utils import QuantumInstance

# Number to factorize
N = 15

# Create simulator
simulator = AerSimulator()

# Quantum instance
quantum_instance = QuantumInstance(simulator)

# Initialize Shor's Algorithm
shor = Shor(quantum_instance=quantum_instance)

# Run the algorithm
result = shor.factor(N)

# Display result
print("Number to factorize:", N)
print("Factors found:", result.factors)


/////////////////////////////////////

Program 2
Write and execute a Python program to implement a Quantum Half Adder Circuit using
quantum gates.
Expected Outcome:
The program should display correct SUM and CARRY outputs


//////////////////////////////////////////



from qiskit import QuantumCircuit, transpile
from qiskit_aer import AerSimulator

# ------------------------------------------------
# Quantum Half Adder
# q0 = Input A
# q1 = Input B
# q2 = SUM
# q3 = CARRY
# ------------------------------------------------

qc = QuantumCircuit(4, 4)

# ------------------------------------------------
# Inputs
# A = 1
# B = 1
# ------------------------------------------------
qc.x(0)
qc.x(1)

# ------------------------------------------------
# SUM = A XOR B
# ------------------------------------------------
qc.cx(0, 2)
qc.cx(1, 2)

# ------------------------------------------------
# CARRY = A AND B
# ------------------------------------------------
qc.ccx(0, 1, 3)

# ------------------------------------------------
# Measure outputs
# ------------------------------------------------
qc.measure([0, 1, 2, 3], [0, 1, 2, 3])

# Execute circuit
simulator = AerSimulator()
compiled_circuit = transpile(qc, simulator)

job = simulator.run(compiled_circuit, shots=1024)
result = job.result()

# Display result
counts = result.get_counts()

print("Quantum Half Adder Output:")
print(counts)

# Draw the circuit
print(qc.draw())





