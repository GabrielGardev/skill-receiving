function solve(params) {
    const rectangles = [];
  
    for (const [width, height] of params) {
      const rectangle = {
        width,
        height,
        area: function() {
          return this.width * this.height;
        },
        compareTo: function(other) {
            return other.area() - this.area() === 0 
            ? other.width - this.width 
            : other.area() - this.area();
        }
      };
  
      rectangles.push(rectangle);
    }
  
    return rectangles.sort((a, b) => a.compareTo(b));
  }

console.log(
    solve(
        [[10,5], [3,20], [5,12]]
    )
)