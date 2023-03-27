function countMultiplesOfFourOrSix(numbers) {
  let count = 0;

  for (let i = 0; i < numbers.length; i++) {
    if (numbers[i] % 4 === 0 || numbers[i] % 6 === 0) {
      count++;
    }
  }
  return count;
}
