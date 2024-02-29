#!/bin/bash

# Usage check
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <platform-name> <challenge-name>"
  exit 1
fi

PLATFORM=$(echo "$1" | tr '[:upper:]' '[:lower:]') # Convert platform name to lowercase
CHALLENGE_NAME=$2
SRC_PATH="src/main/java"
TEST_PATH="src/test/java"
TEMPLATE_PACKAGE="templatepackage"
PLATFORM_PATH="$SRC_PATH/$PLATFORM"
TEST_PLATFORM_PATH="$TEST_PATH/$PLATFORM"

# Ensure the correct directory structure
mkdir -p "$PLATFORM_PATH"
mkdir -p "$TEST_PLATFORM_PATH"

# Copy template package to new challenge package
cp -r "$SRC_PATH/$TEMPLATE_PACKAGE/Template" "$PLATFORM_PATH/$CHALLENGE_NAME"
cp -r "$TEST_PATH/$TEMPLATE_PACKAGE" "$TEST_PLATFORM_PATH/$CHALLENGE_NAME" # Adjusted to copy directly to a new challenge-specific directory

# Function to handle sed in-place editing for compatibility
function sed_inplace() {
    if [[ "$(uname)" == "Darwin" ]]; then
        sed -i '' "$@"
    else
        sed -i "$@"
    fi
}

# Rename package in Java files
find "$PLATFORM_PATH/$CHALLENGE_NAME" -type f -name "*.java" -exec bash -c 'sed_inplace "s/package templatepackage.Template;/package '"$PLATFORM"'.'"$CHALLENGE_NAME"';/g" "$1"' _ {} \;

# Update README.md within the challenge directory, checking if the file exists
README_PATH="$PLATFORM_PATH/$CHALLENGE_NAME/README.md"
if [[ -f "$README_PATH" ]]; then
    sed_inplace "s/# Template Title/# $CHALLENGE_NAME/g" "$README_PATH"
fi

# Update test case package and import statements
find "$TEST_PLATFORM_PATH/$CHALLENGE_NAME" -type f -name "*.java" -exec bash -c 'sed_inplace "s/package templatepackage;/package '"$PLATFORM"';/g" "$1"' _ {} \;
find "$TEST_PLATFORM_PATH/$CHALLENGE_NAME" -type f -name "*.java" -exec bash -c 'sed_inplace "s/import templatepackage.Template.*;/import '"$PLATFORM"'.'"$CHALLENGE_NAME"';/g" "$1"' _ {} \;

echo "Challenge $CHALLENGE_NAME setup completed in platform $PLATFORM."
