import Arrow from "../Arrow"
import Comment from "../Comment"

export default function Comments(){
    return(
        <section className="dark:bg-gray-900 py-8 dark:bg-colordark w-1/2 ">
    <div className="max-w-3xl mx-auto px-4 ">
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-lg lg:text-2xl font-bold text-gray-900">Discussion (20)</h2>
    </div>
    <form className="mb-6">
        <div className="py-2 px-4 mb-4 bg-white rounded-lg rounded-t-lg border border-gray-200 dark:bg-gray-800 dark:border-gray-700">
            <label for="comment" className="sr-only">Your comment</label>
            <textarea id="comment" rows="6"
                className="px-0 w-full text-sm text-gray-900 border-0 focus:ring-0 focus:outline-none dark:text-white dark:placeholder-gray-400 dark:bg-gray-800"
                placeholder="Write a comment..." required></textarea>
        </div>
        <button type="submit"
            className="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-primary rounded-lg focus:ring-4 focus:ring-primary-200 dark:focus:ring-primary-900 hover:bg-primary-800">
            Post comment
        </button>
    </form>
    <Comment />
    <Comment />
    <Comment />
    <Comment />
    <div className="flex flex-col items-center">
        <Arrow />
    </div>
    
  </div>
</section>
    )
}