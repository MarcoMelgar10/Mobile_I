package com.example.practicacalculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf("") }
    var prevNumber by remember { mutableIntStateOf(0) }
    var memoryOperation by remember { mutableStateOf("") }
    var currentOperation by remember { mutableStateOf("") }
    var currentMemory by remember { mutableStateOf("") }
    var memoryNumber by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Row {
            Text(
                text = result.ifEmpty { "0" },
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
        }

        OperationMemoryPanel(
            selectOperationType = { operation ->
                memoryOperation = operation
            },
            onClick = {
                val currentNumber = result.toIntOrNull() ?: 0
                when (memoryOperation) {
                    "M" -> result = memoryNumber.toString()   // recall
                    "M+" -> memoryNumber = memoryNumber + currentNumber
                    "M-" -> memoryNumber = memoryNumber - currentNumber
                    "MR" -> memoryNumber = 0                  // clear memory
                }
                memoryOperation = ""
            }
        )

        NumberPanel(
            onNumberClick = { num ->
                // evita que se agreguen ceros a la izquierda innecesarios
                result = if (result == "0") num else result + num
            }
        )

        OperationsPanel(
            selectOperationType = { theOperation ->
                if (result.isNotEmpty()) {
                    prevNumber = result.toIntOrNull() ?: 0
                    result = ""
                    currentOperation = theOperation
                }
            },
            onEqualsClick = {
                val currentNumber = result.toIntOrNull() ?: 0
                var operationResult = 0
                when (currentOperation) {
                    "+" -> operationResult = prevNumber + currentNumber
                    "-" -> operationResult = prevNumber - currentNumber
                    "x" -> operationResult = prevNumber * currentNumber
                    "/" -> {
                        operationResult = if (currentNumber != 0) {
                            prevNumber / currentNumber // división entera
                        } else {
                            0 // evitar división por cero
                        }
                    }
                }
                result = operationResult.toString()
                currentOperation = ""
                prevNumber = 0
            }
        )

        ClearOperationsPanel(
            onClearOneClick = {
                // protección cuando la cadena está vacía
                result = if (result.isNotEmpty()) result.dropLast(1) else ""
            },
            onClearAllClick = {
                result = ""
            }
        )
    }
}

@Composable
fun ClearOperationsPanel(
    onClearOneClick: () -> Unit = {},
    onClearAllClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        TextButton(
            text = "C",
            onClick = { onClearOneClick() },
            modifier = Modifier
                .weight(1f)
        )
        TextButton(
            text = "CE",
            onClick = { onClearAllClick() },
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun OperationsPanel(
    selectOperationType: (operation: String) -> Unit,
    onEqualsClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(
                text = "+",
                onClick = { selectOperationType("+") },
                modifier = Modifier.weight(1f)
            )
            TextButton(
                text = "-",
                onClick = { selectOperationType("-") },
                modifier = Modifier.weight(1f)
            )
            TextButton(
                text = "x",
                onClick = { selectOperationType("x") },
                modifier = Modifier.weight(1f)
            )
            TextButton(
                text = "/",
                onClick = { selectOperationType("/") },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            TextButton(
                text = "=",
                onClick = { onEqualsClick() },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun OperationMemoryPanel(
    selectOperationType: (operation: String) -> Unit,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextButton("M", {
            selectOperationType("M")
            onClick()
        }, modifier = Modifier.weight(1f))

        TextButton("M+", {
            selectOperationType("M+")
            onClick()
        }, modifier = Modifier.weight(1f))

        TextButton("M-", {
            selectOperationType("M-")
            onClick()
        }, modifier = Modifier.weight(1f))

        TextButton("MR", {
            selectOperationType("MR")
            onClick()
        }, modifier = Modifier.weight(1f))
    }
}

@Composable
fun NumberPanel(
    onNumberClick: (num: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(text = "1", onClick = { onNumberClick("1") }, modifier = Modifier.weight(1f))
            TextButton(text = "2", onClick = { onNumberClick("2") }, modifier = Modifier.weight(1f))
            TextButton(text = "3", onClick = { onNumberClick("3") }, modifier = Modifier.weight(1f))
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(text = "4", onClick = { onNumberClick("4") }, modifier = Modifier.weight(1f))
            TextButton(text = "5", onClick = { onNumberClick("5") }, modifier = Modifier.weight(1f))
            // Corregido: ahora llama correctamente a onNumberClick con "6"
            TextButton(text = "6", onClick = { onNumberClick("6") }, modifier = Modifier.weight(1f))
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(text = "7", onClick = { onNumberClick("7") }, modifier = Modifier.weight(1f))
            TextButton(text = "8", onClick = { onNumberClick("8") }, modifier = Modifier.weight(1f))
            TextButton(text = "9", onClick = { onNumberClick("9") }, modifier = Modifier.weight(1f))
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(text = "0", onClick = { onNumberClick("0") }, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun TextButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun OperationMemoryPreview(){
    CalculatorTheme {
        Column {
            OperationMemoryPanel(selectOperationType = {},onClick = {})
        }
    }
}

@Preview
@Composable
fun ClearOperationsPanelPreview() {
    CalculatorTheme {
        Column {
            ClearOperationsPanel(onClearOneClick = {}, onClearAllClick = {})
        }
    }
}

@Preview
@Composable
fun OperationsPanelPreview() {
    CalculatorTheme {
        Column {
            OperationsPanel(selectOperationType = {}, onEqualsClick = {})
        }
    }
}

@Preview
@Composable
fun NumberPanelPreview() {
    CalculatorTheme {
        Column {
            NumberPanel(onNumberClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}
