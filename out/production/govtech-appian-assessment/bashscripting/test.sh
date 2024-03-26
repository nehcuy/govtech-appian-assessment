#!/bin/bash

# Define the input and output directories
input_dir="src/bashscripting/inputs"
output_dir="src/bashscripting/outputs"
java_output_dir="src"

find -name "*.java" > sources.txt
javac @sources.txt

# Create an array of input files
input_files=(${input_dir}/*.in)

# Iterate through the input files
for input_file in "${input_files[@]}"; do
    # Extract the corresponding output file name
    output_file="${output_dir}/$(basename ${input_file%.in}.out)"

    # Capture the output
    your_output=$(java -cp ${java_output_dir} main.Main ${input_file})
    echo -e "\n"
    echo $your_output

    # Read the actual output
    actual_output=$(<"${output_file}")

    # Compare the output
    if [ "${your_output}" != "${actual_output}" ]; then
        echo "Failed test: $(basename ${input_file})"
    else
        echo "Passed test: $(basename ${input_file})"
    fi
done
