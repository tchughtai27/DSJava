import sys
import io

# Set UTF-8 encoding for standard output
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

# Print a different Unicode character for testing
print("\u2660")  # ✔ (checkmark)
