# Poker

## Test cases

### 1.
```
input
    player1: ["5H"]
    player2: ["9D"]

output
    player2 win

```

### 2.
```
input
    player1: ["AH"]
    player2: ["TD"]

output
    player1 win

```

### 3.
```
input
    player1: ["4H", "4D"]
    player2: ["TD", "AS"]

output
    player1 win

```

### 4.
```
input
    player1: ["TH", "8D"]
    player2: ["AD", "2S"]

output
    player2 win

```

### 5.
```
input
    player1: ["4H", "4D"]
    player2: ["4C", "4S"]

output
    peace

```

### 6.
```
input
    player1: ["4H", "4D", "8S", "8C"]
    player2: ["4C", "4S", "TC", "QH"]

output
    player1 win
```

### 7.
```
input
    player1: ["4H", "4D", "8S", "8C", "JD"]
    player2: ["4C", "4S", "TC", "TH", "2C"]

output
    player2 win
```

### 8.
```
input
    player1: ["4H", "4D", "8S", "8C", "JD"]
    player2: ["4C", "4S", "8D", "8H", "9C"]

output
    player1 win
```

### 9.
```
// three of a kind
input
    player1: ["4H", "4D", "4S", "8C", "JD"]
    player2: ["TC", "TS", "8D", "8H", "QC"]

output
    player1 win
```

### 9.
```
// three of a kind
input
    player1: ["4H", "4D", "4S", "8C", "JD"]
    player2: ["TC", "TS", "TD", "3H", "5C"]

output
    player2 win
```

### 10.
```
// straight
input
    player1: ["4H", "4D", "4S", "8C", "JD"]
    player2: ["5C", "6S", "7D", "8H", "9C"]

output
    player2 win
```

### 11.
```
// straight
input
    player1: ["8C", "9D", "TS", "JC", "QD"]
    player2: ["5C", "6S", "7D", "8H", "9C"]

output
    player1 win
```

### 12.
```
// flush
input
    player1: ["2C", "9C", "7C", "JC", "AC"]
    player2: ["5C", "6S", "7D", "8H", "9C"]

output
    player1 win
```

### 13.
```
// flush
input
    player1: ["2C", "9C", "7C", "JC", "AC"]
    player2: ["5S", "TS", "AS", "3S", "9S"]

output
    player1 win
```

### 14.
```
// full house
input
    player1: ["2C", "2H", "2S", "JC", "JD"]
    player2: ["5S", "TS", "AS", "3S", "9S"]

output
    player1 win
```

### 14.
```
// full house
input
    player1: ["2C", "2H", "2S", "JC", "JD"]
    player2: ["5S", "5D", "5C", "9D", "9S"]

output
    player2 win
```

### 15.
```
// four of a kind
input
    player1: ["2C", "2H", "2S", "2D", "JD"]
    player2: ["5S", "5D", "5C", "9D", "9S"]

output
    player1 win
```

### 15.
```
// four of a kind
input
    player1: ["2C", "2H", "2S", "2D", "JD"]
    player2: ["5S", "5D", "5C", "5H", "9S"]

output
    player2 win
```

### 16.
```
// straight flush
input
    player1: ["2C", "3C", "4C", "5C", "6C"]
    player2: ["5S", "5D", "5C", "5H", "9S"]

output
    player1 win
```

### 17.
```
// straight flush
input
    player1: ["2C", "3C", "4C", "5C", "6C"]
    player2: ["5S", "6S", "7S", "8S", "9S"]

output
    player2 win
```

### 18.
```
// straight flush
input
    player1: ["5H", "6H", "7H", "8H", "9H"]
    player2: ["5S", "6S", "7S", "8S", "9S"]

output
    peace
```