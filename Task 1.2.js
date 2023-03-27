function isPalindrome(str) {
  // Convert the input string to lowercase and remove non-alphanumeric characters
  str = str.toLowerCase().replace(/[^a-z0-9]/g, '');

  // Initialize two pointers, one at the beginning and one at the end of the string
  let left = 0;
  let right = str.length - 1;

  // Loop through the string, comparing characters at each end
  while (left < right) {
    if (str[left] !== str[right]) {
      // If characters don't match, return false (not a palindrome)
      return false;
    }
    // Move both pointers towards the center
    left++;
    right--;
  }

  // If we've made it all the way through the string, it's a palindrome!
  return true;
}
