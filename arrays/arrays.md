# Array Problem Idioms

## Index/Order Matters → Don't Sort
When you need element indices or original order, avoid sorting.

## Min/Max Element with Extreme Frequency
- Reset key when finding new extreme frequency
- Same frequency → `key = Math.min/max(key, newElement)`

## Conditional Length Tracking
- **Inc/dec on condition, calc max only when false:** Add `Math.max(maxLen, currLen)` after loop
- **Otherwise:** Check for new max length every iteration 