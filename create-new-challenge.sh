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
README_PATH="$PLATFORM_PATH/$CHALLENGE_NAME/readme.md"
TEST_PLATFORM_PATH="$TEST_PATH/$PLATFORM"

# Ensure the correct directory structure
mkdir -p "$PLATFORM_PATH"
mkdir -p "$TEST_PLATFORM_PATH"

# Copy template package to new challenge package
cp -r "$SRC_PATH/$TEMPLATE_PACKAGE/Template" "$PLATFORM_PATH/$CHALLENGE_NAME"
cp -r "$TEST_PATH/$TEMPLATE_PACKAGE/SolutionTest.java" "$TEST_PLATFORM_PATH/SolutionTest.java" # Adjusted for direct copy

# Determine the correct sed command based on the operating system
SED_CMD="sed -i"
if [[ "$(uname)" == "Darwin" ]]; then
    SED_CMD="sed -i ''"
fi

# Rename package in Java files
find "$PLATFORM_PATH/$CHALLENGE_NAME" -type f -name "*.java" -exec $SED_CMD "s/package templatepackage.Template;/package $PLATFORM.$CHALLENGE_NAME;/g" {} \;

# Update README.md within the challenge directory, checking if the file exists
if [[ -f "$README_PATH" ]]; then
    $SED_CMD "s/# Template Title/# $CHALLENGE_NAME/g" "$README_PATH"
fi

# Update test case package and import statements
find "$TEST_PLATFORM_PATH" -type f -name "*.java" -exec $SED_CMD "s/package templatepackage;/package $PLATFORM;/g" {} \;
find "$TEST_PLATFORM_PATH" -type f -name "*.java" -exec $SED_CMD "s/import templatepackage.Template.*;/import $PLATFORM.$CHALLENGE_NAME.*;/g" {} \;

echo "Challenge $CHALLENGE_NAME setup completed in platform $PLATFORM."
