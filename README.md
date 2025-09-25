# Currency Converter

## Overview
This is a simple Java Swing application that converts an amount in Kenyan Shillings (KES) to various other currencies. The conversion is based on predefined exchange rates with USD as the base currency.

## Features
- Converts from Kenyan Shillings (KES) to multiple currencies including East African, African, and global currencies
- Displays conversion results for all supported currencies simultaneously
- User-friendly graphical interface with input field, convert button, and scrollable result area
- Basic input validation with error messages for invalid amounts

## Supported Currencies
- East African Currencies: KES, UGX, TZS, RWF
- Other Global Currencies: USD, CAD, ZAR, GBP, SAR, CNY, JPY, INR, AUD, NGN, GHS, ZMW

## Requirements
- Java Development Kit (JDK) 8 or later
- Ability to run Java Swing applications

## Usage
1. Run the `currencyconverter` class.
2. Enter the amount in Kenyan Shillings (KES) in the input field.
3. Click the "Convert" button.
4. The converted amounts to the supported currencies are displayed in the text area below.

## Code Structure
- Exchange rates are stored in a `HashMap` with USD as the base currency.
- The GUI is built using `JFrame` with labels, text fields, buttons, and a text area inside a scroll pane.
- Conversion logic calculates the equivalent amount for each currency relative to KES.
- Results are displayed in a formatted, scrollable text area.

## Example
Entering an amount of `1000` KES and clicking "Convert" will show equivalent values in USD, UGX, TZS, CAD, GBP, and other supported currencies.

## Notes
- Exchange rates are hardcoded and may not reflect current market rates.
- Real-world applications should retrieve rates from a live API for accuracy.This will be present in the next phase of the project
- Input checking ensures only valid numeric amounts are accepted.

## Author
Developed as a sample Java Swing currency converter application.

## License
This project is open source and free to use or modify.
