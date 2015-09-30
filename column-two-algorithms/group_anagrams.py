def signature(word):
    word = "".join(sorted(word))
    return word

def group(words):
    index = {}
    for word in words:
        word_signature = signature(word)

        if word_signature not in index:
            index[word_signature] = set([word])
        else:
            index[word_signature].add(word)
    return index

print group(["pans", "pots", "opt", "snap", "stop", "tops"])
