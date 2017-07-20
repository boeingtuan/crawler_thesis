
namespace java com.bk.thesis.data.thrift

struct TReviewMeta {
	1: i64 lastestDttm,
	2: string lastestId,
	3: i32 length
}

struct TProduct {
	1: string productId,
	2: string url,
	3: string title,	
	4: TReviewMeta cerReviews,
	5: TReviewMeta notcerReviews,
	6: i64 currentTime
}

struct TProductPage {
	1: bool error,
	2: bool exist,
	3: optional string pageData
}

struct TProductResult {
	1: i32 size,
	2: i64 timeComputed
}

struct TRawReviewPage {
	1: bool error,
	2: bool exist,
	3: optional string pageData
}

struct TRawReview {
	1: string reviewId,
	2: string review,
	3: string title,
	4: i32 rating,
	5: i64 createdDttm
}

struct TRawReviewResult {
	1: TReviewMeta cerReviews,
	2: TReviewMeta notcerReviews,
	3: list<TRawReview> listRawReview,
	4: bool canCont
}

struct TTags {
	1: i32 productTag,
	2: i32 branchTag,
	3: i32 detailTag
}

enum ETagType {
	PRODUCT,
	BRANCH,
	DETAIL
}

struct TTag {
	1: i32 tagId,
	2: ETagType type,
	3: string name,
	4: list<i32> parents
}

struct TReview {
	1: i32 reviewId,
	2: string review,
	3: string title,
	4: i32 rating,
	5: i64 createdDttm,
	6: TTags tags,
	7: list<string> tokenizerReview,
	8: list<i32> sequenceReview
}