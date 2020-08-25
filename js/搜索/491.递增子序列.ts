export function findSubsequences(nums: number[]): number[][] {
  const result: number[][] = []
  const { length } = nums
  const map = {} as any
  const dfs = (list: number[], start: number) => {
    if (list.length >= 2) {
      const key = list.join('-')
      if (!map[key]) {
        map[key] = list
        result.push([...list])
      }
    }
    for (let i = start; i < length; i++) {
      const num = nums[i]
      const last = list[list.length - 1]
      if (list.length === 0 || num >= last) {
        list.push(num)
        dfs(list, i + 1)
        list.pop()
      }
    }
  }

  dfs([], 0)

  return result
}
