import subprocess

# Secure way to use subprocess
def run_command(command):
    subprocess.run(command, shell=False)

# Example usage
user_input = input("Enter a command to run: ")
run_command(user_input.split())