local key=KEYS[1]
local max=ARGV[1]
local time=ARGV[2]
local count=redis.call("INCR",key)
if count == 1 then
    redis.call("EXPIRE",key,time)
end
if count > tonumber(max) then
    redis.call("SET",key,0)
    return 0
end
return count