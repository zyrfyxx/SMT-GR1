def parse_automaton_file(file_path):
    result = []

   
    with open(file_path, 'r') as file:
        lines = file.readlines()

    # print(lines)

    
    def parse_bool_dict(dict_str):
        dict_str = dict_str.strip()[1:-1]  
        items = dict_str.split(", ")  
        bool_dict = {}

        for item in items:
            key, value = item.split(":")
            key = key.strip()
            # print(value.strip('}'))
            value = value.strip('}').lower() == "true"  
            bool_dict[key] = value

        return bool_dict

   
    for line in lines:
        
        start_state, rest = line.split("->")
        start_state = start_state.strip()

       
        end_state_and_dicts = rest.split("/")
        end_state_part = end_state_and_dicts[0].strip()
        dict2_str = end_state_and_dicts[1].strip()
        # print(end_state_and_dicts)
        # print(end_state_part)
        # print(dict2_str)

       
        end_state, dict1_str = end_state_part.split(" ", 1)
        end_state = end_state.strip()

        
        dict1 = parse_bool_dict(dict1_str)
        dict2 = parse_bool_dict(dict2_str)

       
        result.append([start_state, end_state, dict1, dict2, dict1 | dict2])

    return result


def parser(currentState, input):

    # print()

    file_path = 'automaton.txt'
    automaton_data = parse_automaton_file(file_path)
    # n=0
    for label in automaton_data:
        stateDict = label[4]
        # print(label)
        if dict(currentState) == dict(stateDict):
            # print(n)
            # n+=1
            # print(currentState)
            # print(stateDict)
            cState = label[1]
            # print(cState)
    for label in automaton_data:
        if cState == label[0]:
            if input == label[2]:
                # print(label[3])
                print("Current State: ", cState)
                print("Transition: ", cState, '->', label[1])
                print("Next State: ", label[1])
                return label[3]
