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