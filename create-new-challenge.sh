#!/bin/bash

# Usage check
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <platform-name> <challenge-name>"
  exit 1
fi

PLATFORM=$1
CHALLENGE_NAME=$2
SRC_PATH="src/main/java"
TEST_PATH="src/test/java"
TEMPLATE_PACKAGE="templatepackage"
PLATFORM_PATH="$SRC_PATH/$PLATFORM"
TEST_PLATFORM_PATH="$TEST_PATH/$PLATFORM"

# Create or use existing platform package
mkdir -p "$PLATFORM_PATH"
mkdir -p "$TEST_PLATFORM_PATH"

# Copy template package to new challenge package
cp -r "$SRC_PATH/$TEMPLATE_PACKAGE/Template" "$PLATFORM_PATH/$CHALLENGE_NAME"
cp -r "$TEST_PATH/$TEMPLATE_PACKAGE" "$TEST_PLATFORM_PATH"

# Rename package in Java files
find "$PLATFORM_PATH/$CHALLENGE_NAME" -type f -name "*.java" -exec sed -i '' "s/package $TEMPLATE_PACKAGE.Template;/package $PLATFORM.$CHALLENGE_NAME;/g" {} \;

# Update README.md within the challenge directory
sed -i '' "s/# Template Title/# $CHALLENGE_NAME/g" "$PLATFORM_PATH/$CHALLENGE_NAME/README.md"

# Update test case package and import statements
find "$TEST_PLATFORM_PATH/$TEMPLATE_PACKAGE" -type f -name "SolutionTest.java" -exec sed -i '' "s/package $TEMPLATE_PACKAGE;/package $PLATFORM;/g" {} \;
find "$TEST_PLATFORM_PATH/$TEMPLATE_PACKAGE" -type f -name "SolutionTest.java" -exec sed -i '' "s/import $TEMPLATE_PACKAGE.Template.*;/import $PLATFORM.$CHALLENGE_NAME.*;/g" {} \;

# Rename the template package directory in tests to match the challenge name
mv "$TEST_PLATFORM_PATH/$TEMPLATE_PACKAGE" "$TEST_PLATFORM_PATH/$CHALLENGE_NAME"

echo "Challenge $CHALLENGE_NAME setup completed in platform $PLATFORM."
