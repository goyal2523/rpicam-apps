import os

def run_command(user_input):
    # Command injection vulnerability
    command = f"sh -c {user_input}"
    os.system(command)

if __name__ == "__main__":
    user_input = "ls"  # Simulating user input
    run_command(user_input)